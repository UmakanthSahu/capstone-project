import React from "react";
import { Logo } from "../logo";
import { NavLinks } from "./navlinks";
import { Accessibility } from "./accessibility";
import { Link, useMatch, useResolvedPath } from "react-router-dom"

import styled from "styled-components";

const NavbarContainer = styled.div`
  /*width: 100%;*/
  height: 60px;
  box-shadow: 0 1px 3px rgba(15, 15, 15, 0.13);
  display: flex;
  align-items: center;
  padding: 0 1.5em;
`;

const LeftSection = styled.div`
  display: flex;
`;

const MiddleSection = styled.div`
  display: flex;
  flex: 3;
  height: 100%;
  justify-content: center;
  //margin-left:auto;
  //margin-right:auto;
  align-items:center;
`;

const RightSection = styled.div`
  display: flex;

`;

export function Navbar(props) {


  return (
    <NavbarContainer>
      <LeftSection>
      <Logo/>
      </LeftSection>
      <MiddleSection><NavLinks /></MiddleSection>
      <RightSection>
      <Accessibility/>
      </RightSection>
    </NavbarContainer>
  );
}