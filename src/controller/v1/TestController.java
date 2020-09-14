package controller.v1;

import model.Result.mdlResult;
import org.springframework.web.bind.annotation.*;

@RestController
public class TestController {
    @RequestMapping(value = "/getproduct", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    mdlResult GetProduct(@RequestParam(value = "id", required = false) String id,
                         @RequestParam(value = "nama_barang", required = false) String nama_barang,
                         @RequestParam(value = "kode_barang", required = false) String kode_barang){
        return adapter.ProductAdapter.GetProduct(id, nama_barang, kode_barang);
    }
}
