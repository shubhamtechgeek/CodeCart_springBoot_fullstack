import React from "react";

const HomeSectionCard = () => {
  return (
    <div
      className="cursor-pointer flex felx-col items-center bg-white rounded-lg 
    shadow-lg overflow-hidden w-[20rem] mx-3 border border-black"
    >
      <div className="h-[12rem] w-[10rem]">
        <img
          className="object-cover object-top w-full h-full"
          src="https://www.mannerless.in/cdn/shop/files/1_1.png?v=1687176004&width=360"
          alt=""
        />
      </div>

      <div className="p-4">
        <h3 className="text-lg font-medium text-gray-900">Baki Hanma</h3>
        <p className="mt-2 text-sm text-gray-500">Copied from Mannerless.in</p>
      </div>
    </div>
  );
};

export default HomeSectionCard;
