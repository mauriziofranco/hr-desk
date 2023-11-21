import React from "react";

import './SingleQuestionInput.css';
import { FormControlLabel, Radio, RadioGroup, TextField } from "@material-ui/core";

export default class SingleQuestionInput extends React.Component {

  render ()  {
      return (
          <div className="radio-group">

            <TextField
              label={this.props.answerPlaceholder}
              name={this.props.answerPropertyName}
              className="singleQuestionTextAnswer"
              onChange={this.props.handleChange}
            />
            <RadioGroup
              row
              aria-labelledby="demo-row-radio-buttons-group-label"
              name={this.props.userAnswerPropertyName}
            >
                <FormControlLabel value="true" control={<Radio id={this.props.cansc} onChange={this.props.handleChange} value="true"/>}  label="vero" />
                <FormControlLabel value="false" control={<Radio id={this.props.cansc} onChange={this.props.handleChange} value="false"/>} label="false" />
            </RadioGroup>
          </div>
      ) ;
  }

}