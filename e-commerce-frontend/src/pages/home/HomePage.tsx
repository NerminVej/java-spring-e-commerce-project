import Footer from "../../components/Footer";
import Hero from "../../components/Hero";
import Incentive from "../../components/Incentive";
import Navbar from "../../components/Navbar";
import PromoSection from "../../components/PromoSection";

const HomePage = () => {

  const navigate = useNavigate();
  
  const handleLogout = () => {
    localStorage.removeItem('authToken');
    navigate('/login');
  };


  return (
    <div>
      <Navbar />
      <Incentive />
      <Hero />
      <PromoSection />
      <Footer />
    </div>
  );
};

export default HomePage;
