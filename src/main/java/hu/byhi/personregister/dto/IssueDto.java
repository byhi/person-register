package hu.byhi.personregister.dto;

import java.time.LocalDateTime;

public class IssueDto {

    private Long id;
    private String name;
    private String description;
    private PersonDto createdBy;
    private LocalDateTime createDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public PersonDto getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(PersonDto createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }
}
