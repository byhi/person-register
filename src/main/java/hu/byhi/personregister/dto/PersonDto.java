package hu.byhi.personregister.dto;


public class PersonDto {

    private Long id;

    private String fullName;

    AddressDto mainAddress;

    AddressDto tempAddress;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public AddressDto getMainAddress() {
        return mainAddress;
    }

    public void setMainAddress(AddressDto mainAddress) {
        this.mainAddress = mainAddress;
    }

    public AddressDto getTempAddress() {
        return tempAddress;
    }

    public void setTempAddress(AddressDto tempAddress) {
        this.tempAddress = tempAddress;
    }
}
