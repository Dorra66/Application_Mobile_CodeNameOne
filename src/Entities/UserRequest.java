/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;



/**
 *
 * @author LENOVO
 */
public class UserRequest {
    
    
    private int idRequest,memberId,bookId,memberMobile,issuePeriod;
    private String bookTitle,memberName,memberLastName,memberMail,issueDate,requestState;
    public UserRequest() {
    }

    public int getIdRequest() {
        return idRequest;
    }

    public void setIdRequest(int idRequest) {
        this.idRequest = idRequest;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getMemberLastName() {
        return memberLastName;
    }

    public void setMemberLastName(String memberLastName) {
        this.memberLastName = memberLastName;
    }

    public String getMemberMail() {
        return memberMail;
    }

    public void setMemberMail(String memberMail) {
        this.memberMail = memberMail;
    }

    public int getMemberMobile() {
        return memberMobile;
    }

    public void setMemberMobile(int memberMobile) {
        this.memberMobile = memberMobile;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    public int getIssuePeriod() {
        return issuePeriod;
    }

    public void setIssuePeriod(int issuePeriod) {
        this.issuePeriod = issuePeriod;
    }

    public String getRequestState() {
        return requestState;
    }

    public void setRequestState(String requestState) {
        this.requestState = requestState;
    }

    @Override
    public String toString() {
        return "UserRequest{" + "idRequest=" + idRequest + ", memberId=" + memberId + ", bookId=" + bookId + ", memberMobile=" + memberMobile + ", issuePeriod=" + issuePeriod + ", bookTitle=" + bookTitle + ", memberName=" + memberName + ", memberLastName=" + memberLastName + ", memberMail=" + memberMail + ", requestState=" + requestState + ", issueDate=" + issueDate + '}';
    }
   
}
