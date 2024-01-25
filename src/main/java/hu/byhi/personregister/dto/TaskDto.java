package hu.byhi.personregister.dto;

import hu.byhi.personregister.common.IssueState;
import hu.byhi.personregister.entity.Issue;
import java.time.LocalDateTime;

public class TaskDto {

    private Long id;
    private Issue issue;

    private PersonDto customer;

    private PersonDto assignee;

    private IssueState state;
    private String comment;
    private LocalDateTime createDate;
    private LocalDateTime startDate;
    private LocalDateTime finshDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Issue getIssue() {
        return issue;
    }

    public void setIssue(Issue issue) {
        this.issue = issue;
    }

    public PersonDto getCustomer() {
        return customer;
    }

    public void setCustomer(PersonDto customer) {
        this.customer = customer;
    }

    public PersonDto getAssignee() {
        return assignee;
    }

    public void setAssignee(PersonDto assignee) {
        this.assignee = assignee;
    }

    public IssueState getState() {
        return state;
    }

    public void setState(IssueState state) {
        this.state = state;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getFinshDate() {
        return finshDate;
    }

    public void setFinshDate(LocalDateTime finshDate) {
        this.finshDate = finshDate;
    }
}
