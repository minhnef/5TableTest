package com.example.demo.service;

import com.example.demo.entity.ProductDetails;
import com.example.demo.entity.respon.Respon;
import com.example.demo.repository.IProductDetailsRepo;
import com.example.demo.repository.IPropertyDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductDetailsSer {
    @Autowired
    private IProductDetailsRepo productDetailsRepo;

    /*
    1.	Viết API mua 1 số lượng sản phẩm nhất định phải check được nếu sản phẩm không đủ
    trả ra Response với tiêu đề không đủ và nếu sản phẩm hết hàng cũng phải trả ra tiêu đề hết hàng
    khi sản phẩm đủ số lượng thì trả ra tiêu đề mua thành công và
    trừ đúng số lượng trong bảng ProductDetails với tất cả các đời thuộc tính.
     */
    public Respon<?> shopping(int productdetailid, int quantity){
        if(productDetailsRepo.sanPhamDoiCuoi().contains(productdetailid)){
            Optional<ProductDetails>op = productDetailsRepo.findById(productdetailid);
            ProductDetails pd = op.get();
            if(pd.getQuantity()==0){
                return new Respon<>(3, "San pham da het hang", pd);
            }
            if(pd.getQuantity()<quantity){
                return new Respon<>(2, "So luong san pham trong cua hang khong du", pd);
            }
            pd.setQuantity(pd.getQuantity()-quantity);
            productDetailsRepo.save(pd);
            return new Respon<>(0, "Dat don hang thanh cong", null);
        }
        return new Respon<>(1, "San pham chua phai la san pham doi cuoi hoac khong ton tai. Kiem tra lai productdetailID", null);
    }

    /*
    2.	Viết API cập nhật số lượng cho sản phẩm bất kì sao cho số lượng các đời thuộc tính không bị sai lệch
     */
    public Respon<?> capNhat(int productdetailid, int quantity) {
        if (productDetailsRepo.sanPhamDoiCuoi().contains(productdetailid)) {
            Optional<ProductDetails> op = productDetailsRepo.findById(productdetailid);
            ProductDetails pd = op.get();
            pd.setQuantity(pd.getQuantity()+quantity);
            productDetailsRepo.save(pd);
            return new Respon<>(0, "Cap nhat thanh cong", pd);
        }

        return new Respon<>(1, "San pham chua phai la san pham doi cuoi hoac khong ton tai. Kiem tra lai productdetailID", null);
    }


    //3.	Viết API trả ra tất cả dữ liệu của bảng ProductDetails với yêu cầu là thuộc tính đời cuối cùng của sản phẩm.

    public Respon<?> hienThiDoiCuoiCung() {
        return new Respon<>(0, "Hien thi chi tiet san pham doi cuoi cung", productDetailsRepo.hienThiThuocTinhDoiCuoi());
    }

}
