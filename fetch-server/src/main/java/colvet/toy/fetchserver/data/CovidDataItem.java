package colvet.toy.fetchserver.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("CovidData")
public class CovidDataItem {
    @Id
    private String id;
    private Integer defCnt;
    private Integer isolClearCnt;
    private Integer localOccCnt;
    private Integer incDec;
    private String createDt;
    private String gubun;
    private String gubunEn;
    private Integer deathCnt;
    private String stdDay;
    private String qurRate;
    private Integer overFlowCnt;
    private String gubunCn;
    private Integer isolIngCnt;
    private Integer seq;

}


//defCnt: 906,
//isolClearCnt: 658,
//localOccCnt: 0,
//incDec: 20,
//updateDt: null,
//createDt: "2020-07-16 10:23:26.581",
//gubun: "검역",
//gubunEn: "Lazaretto",
//deathCnt: 0,
//stdDay: "2020년 07월 16일 00시",
//qurRate: "-",
//overFlowCnt: 20,
//gubunCn: "隔離區",
//isolIngCnt: 248,
//seq: 3028

//<createDt>2020-07-28 10:13:49.492</createDt>
//<deathCnt>0</deathCnt>
//<defCnt>26</defCnt>
//<gubun>제주</gubun>
//<gubunCn>济州</gubunCn>
//<gubunEn>Jeju</gubunEn>
//<incDec>0</incDec>
//<isolClearCnt>19</isolClearCnt>
//<isolIngCnt>7</isolIngCnt>
//<localOccCnt>0</localOccCnt>
//<overFlowCnt>0</overFlowCnt>
//<qurRate>3.88</qurRate>
//<seq>3350</seq>
//<stdDay>2020년 07월 28일 00시</stdDay>
//<updateDt>null</updateDt>