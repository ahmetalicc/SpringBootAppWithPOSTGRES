package sau.demo.Business.Concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import sau.demo.Business.Abstracts.ProductService;
import sau.demo.Core.Utilites.Results.DataResult;
import sau.demo.Core.Utilites.Results.Result;
import sau.demo.Core.Utilites.Results.SuccessDataResult;
import sau.demo.Core.Utilites.Results.SuccessResult;
import sau.demo.DataAccess.Abstracts.ProductDao;
import sau.demo.Entities.Concretes.Product;
import sau.demo.Entities.Dtos.ProductWithCategoryDto;

import java.util.List;
@Service
public class ProductManager implements ProductService {

    private ProductDao productDao;

    @Autowired
    public ProductManager(ProductDao productDao) {
        this.productDao = productDao;
    }
    @Override
    public DataResult<List<Product>> getAll() {
        return new SuccessDataResult<List<Product>>(this.productDao.findAll(),
                "Data listelendi.");

    }

    @Override
    public DataResult<List<Product>> getAllSorted() {
        Sort sort = Sort.by(Sort.Direction.DESC, "productName");
        return new SuccessDataResult<List<Product>>
                (this.productDao.findAll(sort), "Başarılı");
    }

    @Override
    public DataResult<List<Product>> getAll(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return new SuccessDataResult<List<Product>>
                (this.productDao.findAll(pageable).getContent());
    }

    @Override
    public Result add(Product product) {
        this.productDao.save(product);
        return new SuccessResult("Ürün eklendi.");
    }

    @Override
    public DataResult<Product> getByProductName(String productName) {
        return new SuccessDataResult<Product>
                (this.productDao.getByProductName(productName),
                "Data listelendi.");
    }

    @Override
    public DataResult<Product> getByProductNameAndCategoryId(String productName, int categoryId) {
        //business codes
        return new SuccessDataResult<Product>
                (this.productDao.getByProductNameAndCategory_CategoryId(productName, categoryId),
                        "Data listelendi.");
    }

   @Override
    public DataResult<List<Product>> getByProductNameOrCategoryId(String productName, int categoryId) {
        return new SuccessDataResult<List<Product>>
                (this.productDao.getByProductNameOrCategory_CategoryId(productName, categoryId),
                "Data listelendi.");
    }

    @Override
    public DataResult<List<Product>> getByCategoryIdIn(List<Integer> categories) {
        return new SuccessDataResult<List<Product>>
                (this.productDao.getByCategoryIn(categories),
                        "Data listelendi.");
    }

    @Override
    public DataResult<List<Product>> getByProductNameContains(String productName) {
        return new SuccessDataResult<List<Product>>
                (this.productDao.getByProductNameContains(productName),
                        "Data listelendi.");
    }

    @Override
    public DataResult<List<Product>> getByProductNameStartsWith(String productName) {
        return new SuccessDataResult<List<Product>>
                (this.productDao.getByProductNameStartsWith(productName),
                        "Data listelendi.");
    }

    @Override
    public DataResult<List<Product>> getByNameAndCategory(String productName, int categoryId) {
        return new SuccessDataResult<List<Product>>
                ( this.productDao.getByNameAndCategory(productName, categoryId),
                "Data listelendi.");

    }

    @Override
    public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails() {
        return new SuccessDataResult<List<ProductWithCategoryDto>>
                (this.productDao.getProductWithCategoryDetails(),
                "Data listelendi.");
    }


}
