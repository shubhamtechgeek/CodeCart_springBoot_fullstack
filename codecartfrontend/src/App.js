import './App.css';
import Footer from './customer/components/footer/footer';
import Navigation from './customer/components/navigation/navigation';
import HomePage from './customer/Pages/homePage/homePage';


function App() {
  return (
    
    <div className="">
      <Navigation/>
      <div>
        <HomePage/>
      </div>
      <Footer/>
    </div>
  );
}

export default App;
