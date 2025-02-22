package br.com.vechiato.donnacida_api.mapper;

import br.com.vechiato.donnacida_api.dto.AddressDto;
import br.com.vechiato.donnacida_api.dto.CaregiverDto;
import br.com.vechiato.donnacida_api.entity.Address;
import br.com.vechiato.donnacida_api.entity.Caregiver;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-22T19:49:34-0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 17.0.12 (Amazon.com Inc.)"
)
public class CaregiverMapperImpl implements CaregiverMapper {

    @Override
    public Caregiver toEntity(CaregiverDto dto) {
        if ( dto == null ) {
            return null;
        }

        Caregiver.CaregiverBuilder caregiver = Caregiver.builder();

        caregiver.caregiverId( dto.caregiverId() );
        caregiver.cpf( dto.cpf() );
        caregiver.name( dto.name() );
        caregiver.email( dto.email() );
        caregiver.color( dto.color() );
        caregiver.thumbnail( dto.thumbnail() );
        caregiver.address( addressDtoToAddress( dto.address() ) );

        return caregiver.build();
    }

    @Override
    public CaregiverDto toDto(Caregiver entity) {
        if ( entity == null ) {
            return null;
        }

        String caregiverId = null;
        String cpf = null;
        String name = null;
        String email = null;
        String color = null;
        String thumbnail = null;
        AddressDto address = null;

        caregiverId = entity.getCaregiverId();
        cpf = entity.getCpf();
        name = entity.getName();
        email = entity.getEmail();
        color = entity.getColor();
        thumbnail = entity.getThumbnail();
        address = addressToAddressDto( entity.getAddress() );

        CaregiverDto caregiverDto = new CaregiverDto( caregiverId, cpf, name, email, color, thumbnail, address );

        return caregiverDto;
    }

    protected Address addressDtoToAddress(AddressDto addressDto) {
        if ( addressDto == null ) {
            return null;
        }

        Address.AddressBuilder address = Address.builder();

        address.address( addressDto.address() );
        address.number( addressDto.number() );
        address.neighborhood( addressDto.neighborhood() );
        address.zipCode( addressDto.zipCode() );
        address.city( addressDto.city() );
        address.state( addressDto.state() );
        address.country( addressDto.country() );

        return address.build();
    }

    protected AddressDto addressToAddressDto(Address address) {
        if ( address == null ) {
            return null;
        }

        String address1 = null;
        String number = null;
        String neighborhood = null;
        String zipCode = null;
        String city = null;
        String state = null;
        String country = null;

        address1 = address.getAddress();
        number = address.getNumber();
        neighborhood = address.getNeighborhood();
        zipCode = address.getZipCode();
        city = address.getCity();
        state = address.getState();
        country = address.getCountry();

        AddressDto addressDto = new AddressDto( address1, number, neighborhood, zipCode, city, state, country );

        return addressDto;
    }
}
