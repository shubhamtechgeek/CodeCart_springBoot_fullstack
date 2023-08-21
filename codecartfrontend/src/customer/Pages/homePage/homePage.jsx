import React from 'react'
import HomeSectionCarousel from '../../components/homeSectionCarousel/homeSectionCarousel';
import MainCarousel from '../../components/homeCarousel/mainCarousel';



const HomePage = () => {
  return (
    <div>
        <MainCarousel/>
        <div className='space-y-10 py-20 flex flex-col justify center px-5 lg:px-10'>
            <HomeSectionCarousel/>
            <HomeSectionCarousel/>
          
        </div>
    </div>
  )
  
}

export default HomePage;