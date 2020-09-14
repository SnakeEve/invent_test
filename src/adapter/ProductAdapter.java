package adapter;

import database.QueryAdapter;

import javax.sql.rowset.CachedRowSet;
import java.util.ArrayList;
import java.util.List;

public class ProductAdapter {
	public static model.Result.mdlResult GetProduct(String id, String nama_barang, String kode_barang) {
		model.Result.mdlResult result = new model.Result.mdlResult();
		String Query = "SELECT id, nama_barang, kode_barang, jumlah_barang, tanggal FROM produk " +
				"WHERE id = IFNULL(?,id) AND nama_barang = IFNULL(?,nama_barang) AND kode_barang = IFNULL(?,kode_barang)";
		try {
			List<model.Query.mdlQueryExecute> listParam = new ArrayList<>();
			listParam.add(QueryAdapter.QueryParam("string", id ));
			listParam.add(QueryAdapter.QueryParam("string", nama_barang ));
			listParam.add(QueryAdapter.QueryParam("string", kode_barang ));
			CachedRowSet crs = QueryAdapter.QueryExecute(Query, listParam,"GetProduct", "TEST");

			List<model.Product.mdlProduk> data_list = new ArrayList<>();
			while (crs.next()){
				model.Product.mdlProduk data = new model.Product.mdlProduk();
				data.id = crs.getInt("id");
				data.nama_barang = crs.getString("nama_barang");
				data.kode_barang = crs.getString("kode_barang");
				data.jumlah_barang = crs.getInt("jumlah_barang");
				data.tanggal = crs.getString("tanggal");
				data_list.add(data);
			}

			result.status_code = "00";
			result.status_message="Get GetProduct Success";

			result.value = data_list;
		}
		catch(Exception ex) {
			result.status_code = "01";
			result.status_message="Get GetProduct Failed";
		}
		return result;
	}

}
