import { useState } from "react";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import reactLogo from "./assets/react.svg";
import Login from "./pages/login/Login";
import LoginPage from "./pages/login/LoginPage";
import SignInPage from "./pages/signin/SignInPage";
import HomePage from "./pages/home/HomePage";
import ProductPage from "./pages/product/ProductPage";
import ProductOverview from "./components/ProductOverview";

function App() {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<LoginPage />} />
        <Route path="/login" element={<LoginPage />} />
        <Route path="/signin" element={<SignInPage />} />
        <Route path="/home" element={<HomePage />} />
        <Route path="/product/:productname" element={<ProductPage />} />
        <Route path="/product-preview/:productId" element={<ProductOverview />} />
      </Routes>
    </Router>
  );
}

export default App;
