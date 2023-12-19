package sau.demo.Api.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sau.demo.Business.Abstracts.ProductService;
import sau.demo.Core.Utilites.Results.DataResult;
import sau.demo.Core.Utilites.Results.Result;
import sau.demo.Entities.Concretes.Product;
import sau.demo.Entities.Dtos.ProductWithCategoryDto;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductsController {

    private ProductService productService;
    @Autowired
    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/getAll")
    public DataResult<List<Product>> getAll(){
        return this.productService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody Product product){
        return this.productService.add(product);
    }

    @GetMapping("/getByProductName")
    public DataResult<Product> getByProductName(@RequestParam String productName){
        return this.productService.getByProductName(productName);
    }

    @GetMapping("/getByProductNameAndCategoryId")
    public  DataResult<Product>
    getByProductNameAndCategoryId(@RequestParam("productName") String productName,@RequestParam("categoryId") int categoryId){
        return this.productService.getByProductNameAndCategoryId
                (productName, categoryId);
    }

    @GetMapping("/getByProductNameOrCategoryId")
    public DataResult<List<Product>>
    getByProductNameOrCategoryId(@RequestParam("productName") String productName, @RequestParam("categoryId") int categoryId){
        return this.productService.getByProductNameOrCategoryId
                (productName, categoryId);
    }

    @GetMapping("/getByProductNameContains")
    public DataResult<List<Product>> getByProductNameContains(@RequestParam String productName){
        return this.productService.getByProductNameContains(productName);
    }

    @GetMapping("/getAllByPage")
    public DataResult<List<Product>> getAll(int pageNo, int pageSize){
        return this.productService.getAll(pageNo, pageSize);
    }

    @GetMapping("/getAllDesc")
    public DataResult<List<Product>> getAllSorted(){
        return this.productService.getAllSorted();
    }

    @GetMapping("/getProductWithCategoryDetails")
    public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails(){
        return this.productService.getProductWithCategoryDetails();
    }

    @GetMapping("/getByProductNameStartsWith")
    public DataResult<List<Product>> getByProductNameStartsWith(@RequestParam String productName){
        return this.productService.getByProductNameStartsWith(productName);
    }

    @GetMapping("/getByCategoryIdIn")
    public DataResult<List<Product>> getByCategoryIdIn(@RequestParam List<Integer> categories){
        return this.productService.getByCategoryIdIn(categories);
    }

    @GetMapping("/getByNameAndCategory")
    public DataResult<List<Product>> getByNameAndCategory (@RequestParam("productName") String productName,@RequestParam("categoryId") int categoryId){
            return this.productService.getByNameAndCategory(productName, categoryId);
        }


}
