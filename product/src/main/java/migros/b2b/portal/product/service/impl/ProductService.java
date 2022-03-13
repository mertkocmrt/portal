package migros.b2b.portal.product.service.impl;

import migros.b2b.portal.model.entities.Product;
import migros.b2b.portal.model.exceptions.EntityNotFoundException;
import migros.b2b.portal.model.exceptions.NotEnoughStock;
import migros.b2b.portal.model.requests.ProductRequest;
import migros.b2b.portal.product.mappers.ProductMapper;
import migros.b2b.portal.product.repositories.IProductRepository;
import migros.b2b.portal.product.service.IProductService;
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
        Optional<Product> returnedBook = productRepository.findById(id);
        if(returnedBook.isEmpty()){
            throw new EntityNotFoundException();
        }
        return returnedBook.get();
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
