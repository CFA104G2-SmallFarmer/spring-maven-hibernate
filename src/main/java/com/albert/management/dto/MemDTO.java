package com.albert.management.dto;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "mem")
public class MemDTO {

    @Id
    @Column(name = "mem_id")//table名要一致
    @ApiModelProperty(value = "會員ID", example = "1001", required = false, hidden=true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;//變數不能包含下底線，JPA的斷位符是下底線

    @Column(name = "mem_acc")
    @ApiModelProperty(value = "會員帳號", required = true)
    private String memAcc;

    @Column(name = "mem_pwd")
    @ApiModelProperty(value = "會員密碼", required = true)
    private String memPwd;

    @Column(name = "acc_state")
    @ApiModelProperty(value = "帳號狀態", required = true)
    private Integer memAccState;

    @Column(name = "mem_name")
    @ApiModelProperty(value = "會員名稱")
    private String memName;

    @Column(name = "mem_nickname")
    @ApiModelProperty(value = "會員暱稱", required = true)
    private String memNickname;

    @Column(name = "mem_mobile")
    @ApiModelProperty(value = "會員手機號碼", hidden=true)
    private String memMobile;

    @Column(name = "mem_tel")
    @ApiModelProperty(value = "會員電話號碼", hidden=true)
    private String memTel;

    @Column(name = "mem_zipcode")
    @ApiModelProperty(value = "會員郵遞區號", hidden=true)
    private Integer memZipcode;
    @Column(name = "mem_city")
    @ApiModelProperty(value = "居住城市", hidden=true)
    private String memCity;
    @Column(name = "mem_dist")
    @ApiModelProperty(value = "居住地區", hidden=true)
    private String memDist;
    @Column(name = "mem_addr")
    @ApiModelProperty(value = "居住地址", hidden=true)
    private String memAddr;
    @Column(name = "reg_date")
    @ApiModelProperty(value = "註冊日期", required = true)
    private Date regDate;
    @Column(name = "mem_pic")
    @ApiModelProperty(value = "會員頭像",hidden=true)
    private byte[] memPic;
    @Column(name = "rating_score_mk")
    @ApiModelProperty(value = "會員市集評分總分", hidden=true)
    private Integer ratingScoreMk;
    @Column(name = "rating_count_mk")
    @ApiModelProperty(value = "會員市集評分數量", hidden=true)
    private Integer ratingCountMk;
    @Column(name = "rating_score_tr")
    @ApiModelProperty(value = "會員農遊評分總分", hidden=true)
    private Integer ratingScoreTr;
    @Column(name = "rating_count_tr")
    @ApiModelProperty(value = "會員農遊評分數量", hidden=true)
    private Integer ratingCountTr;
    @Column(name = "report_count")
    @ApiModelProperty(value = "會員被檢舉次數", hidden=true)
    private Integer reportCount;
    @Column(name = "mem_id_state")
    @ApiModelProperty(value = "會員id狀態", hidden=true)
    private Integer memIdState;


    public Long getMemId() {
        return id;
    }

    public void setMemId(Long id) {
        this.id = id;
    }

    public String getMemAcc() {
        return memAcc;
    }

    public void setMemAcc(String acc) {
        this.memAcc = acc;
    }

    public String getMemPwd() {
        return memPwd;
    }

    public void setMemPwd(String pwd) {
        this.memPwd = pwd;
    }

    public Integer getAccState() {
        return memAccState;
    }

    public void setAccState(Integer accState) {
        this.memAccState = accState;
    }

    public String getMemName() {
        return memName;
    }

    public void setMemName(String name) {
        this.memName = name;
    }

    public String getMemNickname() {
        return memNickname;
    }

    public void setMemNickname(String nickname) {
        this.memNickname = nickname;
    }

    public String getMemMobile() {
        return memMobile;
    }

    public void setMemMobile(String mobile) {
        this.memMobile = mobile;
    }

    public String getMemTel() {
        return memTel;
    }

    public void setMemTel(String tel) {
        this.memTel = tel;
    }

    public Integer getMemZipcode() {
        return memZipcode;
    }

    public void setMemZipcode(Integer zipcode) {
        this.memZipcode = zipcode;
    }

    public String getMemCity() {
        return memCity;
    }

    public void setMemCity(String city) {
        this.memCity = city;
    }

    public String getMemDist() {
        return memDist;
    }

    public void setMemDist(String dist) {
        this.memDist = dist;
    }

    public String getMemAddr() {
        return memAddr;
    }

    public void setMemAddr(String addr) {
        this.memAddr = addr;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setReg_date(Date regDate) {
        this.regDate = regDate;
    }

    public byte[] getMemPic() {
        return memPic;
    }

    public void setMemPic(byte[] pic) {
        this.memPic = pic;
    }

    public Integer getRatingScoreMk() {
        return ratingScoreMk;
    }

    public void ratingScoreMk(Integer ratingScoreMk) {
        this.ratingScoreMk = ratingScoreMk;
    }

    public Integer getRatingCountMk() {
        return ratingCountMk;
    }

    public void setRating_count_mk(Integer ratingCountMk) {
        this.ratingCountMk = ratingCountMk;
    }

    public Integer getRatingScoreTr() {
        return ratingScoreTr;
    }

    public void setRatingScoreTr(Integer ratingScoreTr) {
        this.ratingScoreTr = ratingScoreTr;
    }

    public Integer getRatingCountTr() {
        return ratingCountTr;
    }

    public void setRatingCountTr(Integer ratingCountTr) {
        this.ratingCountTr = ratingCountTr;
    }

    public Integer getReportCount() {
        return reportCount;
    }

    public void setReportCount(Integer reportCount) {
        this.reportCount = reportCount;
    }

    public Integer getMemIdState() {
        return this.memIdState;
    }

    public void setMemIdState(Integer idState) {
        this.memIdState = idState;
    }

//    public Long getId() {
//        return this.id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return this.name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    @Override
//    public String toString() {
//        return "{" +
//            " id='" + getId() + "'" +
//            ", name='" + getName() + "'" +
//            "}";
//    }

}
