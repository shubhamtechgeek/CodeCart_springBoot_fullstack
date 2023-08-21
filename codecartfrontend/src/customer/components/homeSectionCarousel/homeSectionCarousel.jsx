import React, { useState } from "react";
import AliceCarousel from "react-alice-carousel";
import HomeSectionCard from "../homeSectionCard/homeSectionCard";
import { Button } from "@mui/material";
import KeyboardArrowLeftIcon from "@mui/icons-material/KeyboardArrowLeft";
import { products1 } from "../../../data/products1";

const HomeSectionCarousel = () => {
  const [activeIndex, setActiveIndex]=useState(0);
  const responsive = {
    0: { items: 1 },
    720: { items: 2.5 },
    1024: { items: 3.5 },
  };

  const slidePrev = () => setActiveIndex(activeIndex-1);
  const slideNext = () => setActiveIndex(activeIndex+1);

  const syncActiveIndex = () => ({item})=>setActiveIndex(item)

  

  const items = products1.slice(0, 10).map((item) => <HomeSectionCard product={item}/>);
  //change
  return (
    <div className="relative px-3 sm:p-10 border border-black">
      <div className="relative p-10 ">
        <AliceCarousel
          items={items}
          responsive={responsive}
          disableButtonsControls
          disableDotsControls
        
          onSlideChanged={syncActiveIndex}
          activeIndex={activeIndex}
          
        />
        {activeIndex !== items.length-5 &&  <Button
          variant="contained"
          className="z-50 bg-white"
          onClick={slideNext}
          sx={{
            position: "absolute",
            top: "6rem",
            right: "0rem",
            transform: "translateX(50%) rotate(90deg)",
            bgcolor: "white",
          }}
          aria-label="next"
        >
          <KeyboardArrowLeftIcon
            sx={{ transform: "rotate(90deg)", color: "black" }} />
        </Button>}
        
        <Button
          variant="contained"
          className="z-50 bg-white"
          onClick={slidePrev}
          sx={{
            position: "absolute",
            bottom: "6rem",
            left: "0rem",
            transform: "translateX(-50%) rotate(-90deg)",
            bgcolor: "white",
          }}
          aria-label="next"
        >
            <KeyboardArrowLeftIcon
              sx={{ transform: "rotate(90deg)", color: "black" }} />
          </Button>
      </div>
    </div>
  );

};

export default HomeSectionCarousel;
