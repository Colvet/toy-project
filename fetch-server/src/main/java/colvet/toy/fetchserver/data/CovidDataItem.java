package colvet.toy.fetchserver.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("CovidData")
public class CovidDataItem {

    private String id;
    private Integer defCnt;
    private Integer isolClearCnt;
    private Integer localOccCnt;
    private Integer incDec;
    private Date updateDt;
    private Date createDt;
    private String gubun;
    private String gubunEn;
    private Integer deathCnt;
    private Date stdDay;
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
