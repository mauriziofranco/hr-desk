import React, { Component } from "react";

import Button from "@material-ui/core/Button";

class AddButton extends Component {
  render() {    
    return (
      <Button variant="contained" className={"add-button"} onClick={this.props.onClick}>  +  </Button>
      
    );
  }
}

export default AddButton ;