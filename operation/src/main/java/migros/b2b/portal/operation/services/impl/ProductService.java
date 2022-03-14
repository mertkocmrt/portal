package migros.b2b.portal.operation.services.impl;

import migros.b2b.portal.model.exceptions.EntityNotFoundException;
import migros.b2b.portal.model.exceptions.NotEnoughStock;
import migros.b2b.portal.model.requests.ProductRequest;
import migros.b2b.portal.operation.entities.Product;
import migros.b2b.portal.operation.mappers.ProductMapper;
import migros.b2b.portal.operation.repositories.IProductRepository;
import migros.b2b.portal.operation.services.IProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService {

    private final IProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductService(IProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    public Product getProduct(String id) {
        Optional<Product> returnedProduct = productRepository.findById(id);
        if(returnedProduct.isEmpty()){
            throw new EntityNotFoundException();
        }
        return returnedProduct.get();
    }

    @Override
    public void updateProducts(List<ProductRequest> productRequests) {
        for(ProductRequest product : productRequests) {
            Optional<Product> returnedProduct = productRepository.findById(product.getId());

            if(returnedProduct.isPresent()){
                checkStock(returnedProduct.get(),product);
                productRepository.save(returnedProduct.get());
            }
        }
    }

    private void checkStock(Product returnedProduct, ProductRequest productRequest) {
        int stockLeft = returnedProduct.getStock()-productRequest.getQuantity();
        if(stockLeft > 0) {
            returnedProduct.setStock(stockLeft);
        } else {
            throw new NotEnoughStock();
        }
    }

}
