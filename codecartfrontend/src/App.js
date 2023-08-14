import logo from './logo.svg';
import './App.css';
import Navigation from './customer/components/navigation/navigation';
import HomePage from './customer/Pages/homePage/homePage';


function App() {
  return (
    
    <div className="">
      <Navigation/>
      <div>
        <HomePage/>
      </div>
    </div>
  );
}

export default App;
