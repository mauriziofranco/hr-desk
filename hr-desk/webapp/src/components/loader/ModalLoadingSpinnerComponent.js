import React from 'react';
import { usePromiseTracker } from "react-promise-tracker";
import './LoadingSpinnerComponent.css';
import proxima_arrow from '../../images/logo_big.png'

export const ModalLoadingSpinnerComponent = (props) => {
  const { promiseInProgress } = usePromiseTracker();

  return (
    <div>
    {
       (promiseInProgress === true) ? 
    		   <div className="modalLoaderDialog">
	    		   <div className="loader modalLoader">
	                   <img src={proxima_arrow} alt="loading..." className="proxima_arrow_spinner"/>
	               </div>
               </div>
       : null
    }
  </div>
  )
};