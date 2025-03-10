package hu.byhi.personregister.entity;

import hu.byhi.personregister.common.IssueState;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "Task")
public class Task {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "issue_id", referencedColumnName = "id")
    private Issue issue;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Person customer;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "assignee_id", referencedColumnName = "id")
    private Person assignee;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private IssueState state;
    private String comment;
    @Column(nullable = false)
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

    public Person getAssignee() {
        return assignee;
    }

    public void setAssignee(Person assignee) {
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

    public Person getCustomer() {
        return customer;
    }

    public void setCustomer(Person customer) {
        this.customer = customer;
    }
}
