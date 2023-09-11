import React from 'react'
import HomeSectionCarousel from '../../components/homeSectionCarousel/homeSectionCarousel';
import MainCarousel from '../../components/homeCarousel/mainCarousel';
import { products1 } from '../../../data/products1';



const HomePage = () => {
  return (
    <div>
        <MainCarousel/>
        <div className='space-y-10 py-20 flex flex-col justify center px-5 lg:px-10'>
            <HomeSectionCarousel sectionName={"T-Shirt"}/>
            <HomeSectionCarousel sectionName={"Shirt"}/>
            <HomeSectionCarousel sectionName={"Jeans"}/>
            <HomeSectionCarousel sectionName={"Cargo"}/>
          
        </div>
    </div>
  )
  
}

export default HomePage;