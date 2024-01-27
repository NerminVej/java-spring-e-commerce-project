import { useState } from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import reactLogo from './assets/react.svg';
import Login from './pages/login/Login';
import LoginPage from './pages/login/LoginPage';
import SignInPage from './pages/signin/SignInPage';
import HomePage from './pages/home/HomePage';

function App() {
  return (
    <Router>
      <Routes>
        <Route path="/login" element={<LoginPage />} />
        <Route path="/signin" element={<SignInPage />} />
        <Route path="/home" element={<HomePage />} />

      </Routes>
    </Router>
  );
}

export default App;
