import Hero from "../../components/Hero";
import Incentive from "../../components/Incentive";
import Navbar from "../../components/Navbar";
import PromoSection from "../../components/PromoSection";

const HomePage = () => {
  return (
    <div>
      <Navbar />
      <Hero />
      <PromoSection />
      <Incentive />
    </div>
  );
};

export default HomePage;
