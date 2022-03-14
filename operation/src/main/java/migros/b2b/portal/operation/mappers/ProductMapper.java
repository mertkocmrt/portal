package migros.b2b.portal.operation.mappers;

import migros.b2b.portal.model.requests.ProductRequest;
import migros.b2b.portal.operation.entities.Product;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    private final ModelMapper modelMapper;

    @Autowired
    public ProductMapper(ModelMapper modelMapper){
        this.modelMapper = modelMapper;
    }

    public Product dtoToEntity(ProductRequest productRequest) {
        return modelMapper.map(productRequest, Product.class);
    }
}
