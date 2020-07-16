package colvet.toy.fetchserver.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.GeneratedValue;
import java.util.Date;

@Data

public class CovidDataResponseModel {

//    @GeneratedValue
//    private Integer Id;

    private Integer isolClearCnt;

    private Integer incDec;

    private Date updateDt;

    private Date createDt;

    private String gubun;

    private Integer deathCnt;

    private Date stdDay;

    private Integer isolIngCnt;
}
//isolClearCnt: 18,                         # 격리 해제
//incDec: 0,                                # 전일대비 증가수
//updateDt: null,                           # 수정 일시분추
//createDt: "2020-07-16 10:23:26.581",      # 등록일시
//gubun: "제주",                             # 지역 한글
//deathCnt: 0,                              # 사망자 수
//stdDay: "2020년 07월 16일 00시",            # 기준 일 시
//isolIngCnt: 2,                            # 격리자 수
