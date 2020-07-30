package colvet.toy.fetchserver.service;

import colvet.toy.fetchserver.data.CovidDataItem;
import colvet.toy.fetchserver.data.CovidRepo;
import colvet.toy.fetchserver.model.GubunResponseModel;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.List;

@Slf4j
@Service
public class CovidDataServiceImpl implements CovidDataService {

    private static final String covidUrl = "http://openapi.data.go.kr/openapi/service/rest/Covid19/getCovid19SidoInfStateJson";

    @Value("${open.api.key}")
    private String apiKey;

    @Autowired
    CovidRepo covidRepo;

    @Autowired
    public CovidDataServiceImpl(CovidRepo covidRepo){
        this.covidRepo = covidRepo;
    }


    @Override
    public void fetchAndSaveCovidData() throws IOException, ParseException {
//        StringBuilder urlBuilder = new StringBuilder(covidUrl); /*URL*/
//        urlBuilder.append("?" + URLEncoder.encode(apiKey,"UTF-8") + "=서비스키"); /*Service Key*/
//        urlBuilder.append("&" + URLEncoder.encode(apiKey,"UTF-8") + "=" + URLEncoder.encode("-", "UTF-8")); /*공공데이터포털에서 받은 인증키*/
//        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
//        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과 수*/
//        urlBuilder.append("&" + URLEncoder.encode("startCreateDt","UTF-8") + "=" + URLEncoder.encode("20200410", "UTF-8")); /*검색할 생성일 범위의 시작*/
//        urlBuilder.append("&" + URLEncoder.encode("endCreateDt","UTF-8") + "=" + URLEncoder.encode("20200410", "UTF-8")); /*검색할 생성일 범위의 종료*/

        StringBuffer result = new StringBuffer();
        String urlStr = covidUrl + "?ServiceKey=" + apiKey;
        URL url = new URL(urlStr);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());

        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();

        JSONObject json = XML.toJSONObject(sb.toString());
        JSONArray jsonItems = json.getJSONObject("response").getJSONObject("body").getJSONObject("items").getJSONArray("item");

        for(int i=0; i < jsonItems.length(); i ++){

            JSONObject obj = (JSONObject) jsonItems.get(i);
            CovidDataItem covidDataItem = new CovidDataItem();

            covidDataItem.setDefCnt((Integer) obj.get("defCnt"));
            covidDataItem.setIsolClearCnt((Integer) obj.get("isolClearCnt"));
            covidDataItem.setLocalOccCnt((Integer) obj.get("localOccCnt"));
            covidDataItem.setIncDec((Integer) obj.get("incDec"));
            covidDataItem.setGubun((String) obj.get("gubun"));
            covidDataItem.setGubunEn((String) obj.get("gubunEn"));
            covidDataItem.setDeathCnt((Integer) obj.get("deathCnt"));

            covidDataItem.setCreateDt(obj.get("createDt").toString().split(" ")[0]);

            covidDataItem.setQurRate(obj.get("qurRate").toString());
            covidDataItem.setOverFlowCnt((Integer) obj.get("overFlowCnt"));
            covidDataItem.setGubunCn((String) obj.get("gubunCn"));
            covidDataItem.setIsolIngCnt((Integer) obj.get("isolIngCnt"));
            covidDataItem.setSeq((Integer) obj.get("seq"));

            covidRepo.insert(covidDataItem);
        }
    }

    @Override
    public GubunResponseModel getCovidDataByGubunAndToday(String gubun) {
        String nowDate = LocalDate.now().toString();
        CovidDataItem resultCovidDataItem = covidRepo.findByGubunAndCreateDt(gubun, nowDate);

        GubunResponseModel responseModel = new GubunResponseModel();

        if(resultCovidDataItem == null){
            responseModel.setResult(Boolean.FALSE);
            return responseModel;
        }else{
            responseModel.setResult(Boolean.TRUE);
            responseModel = new ModelMapper().map(resultCovidDataItem, GubunResponseModel.class);
        }

        log.info(responseModel.toString());

        return responseModel;
    }


}
