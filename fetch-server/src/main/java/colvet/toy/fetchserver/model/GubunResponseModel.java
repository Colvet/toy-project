package colvet.toy.fetchserver.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class GubunResponseModel {

    private Integer isolClearCnt;
    private Integer incDec;
    private String createDt;
    private String gubun;
    private Integer deathCnt;
    private Integer isolIngCnt;

    @JsonIgnore
    private Boolean result;

}
//isolClearCnt: 18,                         # 격리 해제
//incDec: 0,                                # 전일대비 증가수
//createDt: "2020-07-16 10:23:26.581",      # 등록일시
//gubun: "제주",                             # 지역 한글
//deathCnt: 0,                              # 사망자 수
//stdDay: "2020년 07월 16일 00시",            # 기준 일 시
//isolIngCnt: 2,                            # 격리자 수
