package sau.demo.DataAccess.Abstracts;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sau.demo.Entities.Concretes.Product;
import sau.demo.Entities.Dtos.ProductWithCategoryDto;

import java.util.List;

public interface ProductDao extends JpaRepository<Product, Integer> {
    Product getByProductName(String productName);

    Product getByProductNameAndCategory_CategoryId(String productName, int categoryId);

    List<Product> getByProductNameOrCategory_CategoryId(String productName, int categoryId);

    List<Product> getByCategoryIn(List<Integer> categories);

    List<Product> getByProductNameContains(String productName);

    List<Product> getByProductNameStartsWith(String productName);

    @Query("From Product where productName=:productName and category.categoryId=:categoryId")
    List<Product> getByNameAndCategory(String productName, int categoryId);

    //select p.productId, p.productName, c.categoryName, from Category c
    // Inner join Product p one c.categoryId = p.categoryId
    @Query("Select new sau.demo.Entities.Dtos.ProductWithCategoryDto"
            +"(p.id, p.productName, c.categoryName) From Category c Inner Join c.products p")
    List<ProductWithCategoryDto> getProductWithCategoryDetails();

}
