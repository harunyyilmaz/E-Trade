package kodlama.io.E.Trade.core.utilities.mappers;


import org.modelmapper.ModelMapper;

public interface ModelMapperService {

    ModelMapper forResponse();
    ModelMapper forRequest();

}
