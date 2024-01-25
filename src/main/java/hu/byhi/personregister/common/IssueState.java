package hu.byhi.personregister.common;

public enum IssueState {
    OPENED("OPENED")
    ,ASSIGNED("ASSIGNED")
    ,IN_PROGRESS("IN_PROGRESS")
    ,SUSPENDED("SUSPENDED")
    ,RESOLVED("RESOLVED")
    ,CLOSED("CLOSED");

    final String value;

    IssueState(String value) {
        this.value = value;
    }
}
