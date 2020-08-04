package colvet.toy.fetchserver.data;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.json.JSONObject;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CovidDataMessage {
    private Integer isolClearCnt;
    private Integer incDec;
    private String gubun;
    private Integer deathCnt;
    private Integer isolIngCnt;
    private MessageType messageType;

//    public JSONObject getJsonFormat(){
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("isolClearCnt", this.isolClearCnt);
//        jsonObject.put("incDec", this.incDec);
//        jsonObject.put("gubun", this.gubun);
//        jsonObject.put("deathCnt", this.deathCnt);
//        jsonObject.put("isolIngCnt", this.isolIngCnt);
//        jsonObject.put("messageType", this.messageType);
//
//        return jsonObject;
//    }

}




//isolClearCnt: 18,                         # 격리 해제
//incDec: 0,                                # 전일대비 증가수
//gubun: "제주",                             # 지역 한글
//deathCnt: 0,                              # 사망자 수
//isolIngCnt: 2,