package com.parking.parkinglot.ejb;

import com.parking.parkinglot.common.ProductDto;
import com.parking.parkinglot.common.ProductPhotoDto;
import com.parking.parkinglot.entities.Product;
import com.parking.parkinglot.entities.ProductPhoto;
import jakarta.ejb.EJBException;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;

@Stateless
public class ProductsBean {
    private static final Logger LOG = Logger.getLogger(ProductsBean.class.getName());

    @PersistenceContext
    EntityManager entityManager;

    public List<ProductDto> findAllProducts(){
        LOG.info("findAllProducts");
        try{
            TypedQuery<Product> typedQuery =
                    entityManager.createQuery("SELECT p FROM Product p", Product.class);
            List<Product> products = typedQuery.getResultList();
            return copyProductsToDto(products);
        } catch (Exception ex){
            throw new EJBException(ex);
        }
    }

    public List<ProductDto> copyProductsToDto(List<Product> products){
        List<ProductDto> productsDto = new LinkedList<>();

        for (Product product : products){
            ProductDto dto = new ProductDto(product.getId(),
                    product.getName(),
                    product.getPrice(),
                    product.getQuantity(),
                    product.getCategory());
            productsDto.add(dto);
        }
        return productsDto;
    }

    public void createProduct(
            String name,
            Float price,
            Integer quantity,
            String category
    ){
        LOG.info("createProduct");

        Product product = new Product();

        product.setName(name);
        product.setPrice(price);
        product.setQuantity(quantity);
        product.setCategory(category);

        entityManager.persist(product);
    }

    public ProductDto findById(Long productId){
        ProductDto product = null;

        List<ProductDto> allProducts = findAllProducts();

        for (ProductDto allProduct : allProducts){
            if(Objects.equals(allProduct.getId(), productId)){
                product = allProduct;
            }
        }
        return product;
    }

    public void updateProduct(
            Long productId,
            String name,
            Float price,
            Integer quantity,
            String category
    ){
        LOG.info("updateProduct");

        Product product = entityManager.find(Product.class, productId);
        product.setName(name);
        product.setPrice(price);
        product.setQuantity(quantity);
        product.setCategory(category);
    }

    public void deleteProductsByIds(Collection<Long> productIds){
        LOG.info("deleteProductsByIds");

        for(Long productId : productIds){
            Product product = entityManager.find(Product.class, productId);
            entityManager.remove(product);
        }
    }
    public void addPhotoToProduct(Long productId, String filename, String fileType, byte[] fileContent){
        LOG.info("addPhotoToProduct");
        ProductPhoto photo = new ProductPhoto();
        photo.setFilename(filename);
        photo.setFileType(fileType);
        photo.setFileContent(fileContent);

        Product product = entityManager.find(Product.class, productId);
        if(product.getPhoto()!=null){
            entityManager.remove(product.getPhoto());
        }
        product.setPhoto(photo);

        photo.setProduct(product);
        entityManager.persist(photo);
    }

    public ProductPhotoDto findPhotoByProductId(Integer productId){
        List<ProductPhoto> photos = entityManager
                .createQuery("SELECT p FROM ProductPhoto p where p.product.id = :id", ProductPhoto.class)
                .setParameter("id", productId).getResultList();
        if(photos.isEmpty()){
            return null;
        }
        ProductPhoto photo = photos.get(0);
        return new ProductPhotoDto(photo.getId(), photo.getFilename(), photo.getFileType(), photo.getFileContent());
    }

    public ProductDto findByName(String productName){
        ProductDto product = null;
        List<ProductDto> allProducts = findAllProducts();

        for(ProductDto allProduct : allProducts){
            if(Objects.equals(allProduct.getName(), productName)){
                product = allProduct;
            }
        }
        return product;
    }

    public ProductDto returnCategory(String productCategory){
        ProductDto product = null;
        List<ProductDto> allProducts = findAllProducts();

        for(ProductDto allProduct : allProducts){
            if(Objects.equals(allProduct.getCategory(), productCategory)){
                product = allProduct;
            }
        }
        return product;
    }
}
