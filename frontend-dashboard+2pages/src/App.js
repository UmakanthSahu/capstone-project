import "./App.css";
import axios from "axios";
import { Navbar } from "./components/navbar";


import React, { useState, useEffect, useMemo } from "react";
import { Route, Routes } from "react-router-dom"

import ViewLoans from "./components/ViewLoans";
import ItemsPurchased from "./components/ItemsPurchased";


function App() {

  return (
    <div className="App">

      <Navbar />

      <div className="container">
              <Routes>
                  <Route path="/" element={<ViewLoans />} />
                <Route path="/ViewLoans" element={<ViewLoans />} />
                <Route path="/ItemsPurchased" element={<ItemsPurchased />} />
              </Routes>
            </div>

    </div>
  );
}

export default App;