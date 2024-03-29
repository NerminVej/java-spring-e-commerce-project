import React from "react";
import ProductList from "../../components/ProductList";
import Navbar from "../../components/Navbar";
import Footer from "../../components/Footer";

const ProductPage = () => {
  return (
    <div>
      <Navbar />
      <ProductList />
      <Footer />
    </div>
  );
};

export default ProductPage;
