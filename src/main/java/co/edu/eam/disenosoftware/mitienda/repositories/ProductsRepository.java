package co.edu.eam.disenosoftware.mitienda.repositories;

import co.edu.eam.disenosoftware.mitienda.exceptions.TecnicalException;
import co.edu.eam.disenosoftware.mitienda.model.entities.Product;
import co.edu.eam.disenosoftware.mitienda.util.APIErrorHandler;
import co.edu.eam.disenosoftware.mitienda.util.RetroFitUtils;
import co.edu.eam.disenosoftware.mitienda.webservices.ProductAPIClient;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;

/**
 * Repository to access products data
 */
public class ProductsRepository {

  /**
   * List getProductByName
   *
   * @param name , name
   * @return list products
   * @ , if response fail
   */
  public List<Product> getProductByName(String name) {
    ProductAPIClient productAPIClient = RetroFitUtils.buildAPIClient(ProductAPIClient.class);
    Call<List<Product>> request = productAPIClient.getProductByName(name);
    try {
      Response<List<Product>> response = request.execute();

      if (response.isSuccessful()) {
        return response.body();
      } else {
        throw APIErrorHandler.throwApiException(response);
      }
    } catch (IOException exc) {
      throw new TecnicalException(exc);
    }
  }
}
