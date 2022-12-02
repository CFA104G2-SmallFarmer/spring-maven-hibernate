package com.albert.management.dto;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "f_mem")
public class FMemDTO {

    @Id
    @Column(name = "f_mem_id")//table名要一致
    @ApiModelProperty(value = "小農會員ID", example = "1001", hidden = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;//變數不能包含下底線，JPA的斷位符是下底線

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name="mem_id")
    @ApiModelProperty(value = "一般會員ID",example = "1001", required = true)
    private MemDTO memId;

    @Column(name = "f_mem_acc")
    @ApiModelProperty(value = "小農會員帳號", required = true)
    private String fMemAcc;

    @Column(name = "f_mem_pwd")
    @ApiModelProperty(value = "小農會員密碼", required = true)
    private String fMemPwd;

    @Column(name = "acc_state")
    @ApiModelProperty(value = "帳號狀態", required = true)
    private Integer accState;

    @Column(name = "f_mem_fname")
    @ApiModelProperty(value = "小農會員名稱", required = true)
    private String fMemFname;

    @Column(name = "f_mem_info")
    @ApiModelProperty(value = "小農會員資訊", hidden = true)
    private String fMemInfo;

    @Column(name = "f_mem_mobile")
    @ApiModelProperty(value = "小農會員手機號碼", required = true)
    private String fMemMobile;

    @Column(name = "f_mem_tel")
    @ApiModelProperty(value = "小農會員電話號碼", hidden = true)
    private String fMemTel;

    @Column(name = "f_mem_zipcode")
    @ApiModelProperty(value = "小農會員郵遞區號", required = true)
    private Integer fMemZipcode;

    @Column(name = "f_mem_city")
    @ApiModelProperty(value = "居住城市", required = true)
    private String fMemCity;

    @Column(name = "f_mem_dist")
    @ApiModelProperty(value = "居住地區", required = true)
    private String fMemDist;

    @Column(name = "f_mem_add")
    @ApiModelProperty(value = "居住地址", required = true)
    private String fMemAddr;

    @Column(name = "bank_code")
    @ApiModelProperty(value = "銀行代號", hidden = true)
    private Integer bankCode;

    @Column(name = "bank_account")
    @ApiModelProperty(value = "銀行帳號", hidden = true)
    private String bankAccount;

    @Column(name = "reg_date")
    @ApiModelProperty(value = "註冊日期", required = true)
    private Date regDate;

    @Column(name = "f_mem_pic")
    @ApiModelProperty(value = "會員頭像", hidden = true)
    private byte[] fMemPic;

    @Column(name = "rating_score_mk")
    @ApiModelProperty(value = "會員市集評分總分", hidden = true)
    private Integer ratingScoreMk;

    @Column(name = "rating_count_mk")
    @ApiModelProperty(value = "會員市集評分數量", hidden = true)
    private Integer ratingCountMk;

    @Column(name = "rating_score_tr")
    @ApiModelProperty(value = "會員農遊評分總分", hidden = true)
    private Integer ratingScoreTr;

    @Column(name = "rating_count_tr")
    @ApiModelProperty(value = "會員農遊評分數量", hidden = true)
    private Integer ratingCountTr;

    @Column(name = "report_count")
    @ApiModelProperty(value = "會員被檢舉次數", hidden = true)
    private Integer reportCount;

    @Column(name = "organic_certi")
    @ApiModelProperty(value = "有機認證狀態", hidden = true)
    private byte[] organicCerti;


    @Column(name = "env_friendly_certi")
    @ApiModelProperty(value = "環境友善認證狀態", hidden = true)
    private byte[] envFriendlyCerti;

    @Column(name = "certi_state")
    @ApiModelProperty(value = "認證狀態", required = true)
    private Integer certiState;


    public Long getF_mem_id() {
        return id;
    }

    public void setF_mem_id(Long f_mem_id) {
        this.id = f_mem_id;
    }

    public MemDTO getMem_id() {
        return memId;
    }

    public void setMem_id(MemDTO mem_id) {
        this.memId = mem_id;
    }

    public String getF_mem_acc() {
        return fMemAcc;
    }

    public void setF_mem_acc(String f_mem_acc) {
        this.fMemAcc = f_mem_acc;
    }

    public String getF_mem_pwd() {
        return fMemPwd;
    }

    public void setF_mem_pwd(String f_mem_pwd) {
        this.fMemPwd = f_mem_pwd;
    }

    public Integer getAcc_state() {
        return accState;
    }

    public void setAcc_state(Integer acc_state) {
        this.accState = acc_state;
    }

    public String getF_mem_fname() {
        return fMemFname;
    }

    public void setF_mem_fname(String f_mem_fname) {
        this.fMemFname = f_mem_fname;
    }

    public String getF_mem_info() {
        return fMemInfo;
    }

    public void setF_mem_info(String f_mem_info) {
        this.fMemInfo = f_mem_info;
    }

    public String getF_mem_mobile() {
        return fMemMobile;
    }

    public void setF_mem_mobile(String f_mem_mobile) {
        this.fMemMobile = f_mem_mobile;
    }

    public String getF_mem_tel() {
        return fMemTel;
    }

    public void setF_mem_tel(String f_mem_tel) {
        this.fMemTel = f_mem_tel;
    }

    public Integer getF_mem_zipcode() {
        return fMemZipcode;
    }

    public void setF_mem_zipcode(Integer f_mem_zipcode) {
        this.fMemZipcode = f_mem_zipcode;
    }

    public String getF_mem_city() {
        return fMemCity;
    }

    public void setF_mem_city(String f_mem_city) {
        this.fMemCity = f_mem_city;
    }

    public String getF_mem_dist() {
        return fMemDist;
    }

    public void setF_mem_dist(String f_mem_dist) {
        this.fMemDist = f_mem_dist;
    }

    public String getF_mem_add() {
        return fMemAddr;
    }

    public void setF_mem_add(String f_mem_add) {
        this.fMemAddr = f_mem_add;
    }

    public Integer getBank_code() {
        return bankCode;
    }

    public void setBank_code(Integer bank_code) {
        this.bankCode = bank_code;
    }

    public String getBank_account() {
        return bankAccount;
    }

    public void setBank_account(String bank_account) {
        this.bankAccount = bank_account;
    }

    public Date getReg_date() {
        return regDate;
    }

    public void setReg_date(Date reg_date) {
        this.regDate = reg_date;
    }

    public byte[] getF_mem_pic() {
        return fMemPic;
    }

    public void setF_mem_pic(byte[] f_mem_pic) {
        this.fMemPic = f_mem_pic;
    }

    public Integer getRating_score_mk() {
        return ratingScoreMk;
    }

    public void setRating_score_mk(Integer rating_score_mk) {
        this.ratingScoreMk = rating_score_mk;
    }

    public Integer getRating_count_mk() {
        return ratingCountMk;
    }

    public void setRating_count_mk(Integer rating_count_mk) {
        this.ratingCountMk = rating_count_mk;
    }

    public Integer getRating_score_tr() {
        return ratingScoreTr;
    }

    public void setRating_score_tr(Integer rating_score_tr) {
        this.ratingScoreTr = rating_score_tr;
    }

    public Integer getRating_count_tr() {
        return ratingCountTr;
    }

    public void setRating_count_tr(Integer rating_count_tr) {
        this.ratingCountTr = rating_count_tr;
    }

    public Integer getReport_count() {
        return reportCount;
    }

    public void setReport_count(Integer report_count) {
        this.reportCount = report_count;
    }

    public byte[] getOrganic_certi() {
        return organicCerti;
    }

    public void setOrganic_certi(byte[] organic_certi) {
        this.organicCerti = organic_certi;
    }

    public byte[] getEnv_friendly_certi() {
        return envFriendlyCerti;
    }

    public void setEnv_friendly_certi(byte[] env_friendly_certi) {
        this.envFriendlyCerti = env_friendly_certi;
    }

    public Integer getCerti_state() {
        return certiState;
    }

    public void setCerti_state(Integer certi_state) {
        this.certiState = certi_state;
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
