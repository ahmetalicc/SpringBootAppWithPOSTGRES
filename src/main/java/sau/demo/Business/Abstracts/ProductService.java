package sau.demo.Business.Abstracts;

import org.springframework.data.jpa.repository.Query;
import sau.demo.Core.Utilites.Results.DataResult;
import sau.demo.Core.Utilites.Results.Result;
import sau.demo.Entities.Concretes.Product;
import sau.demo.Entities.Dtos.ProductWithCategoryDto;

import java.util.List;

public interface ProductService {
   DataResult<List<Product>> getAll();

   DataResult<List<Product>> getAllSorted();
   DataResult<List<Product>> getAll(int pageNo, int pageSize);
   Result add(Product product);

   DataResult<Product> getByProductName(String productName);

   DataResult<Product> getByProductNameAndCategoryId(String productName, int categoryId);

   DataResult<List<Product>> getByProductNameOrCategoryId(String productName, int categoryId);

   DataResult<List<Product>> getByCategoryIdIn(List<Integer> categories);

   DataResult<List<Product>> getByProductNameContains(String productName);

   DataResult<List<Product>> getByProductNameStartsWith(String productName);

   DataResult<List<Product>> getByNameAndCategory(String productName, int categoryId);

   DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails();
}