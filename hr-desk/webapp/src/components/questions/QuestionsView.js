import React, { Component } from 'react';
import QuestionsList from './QuestionsList';
import * as Constants from "../../constants.js";

export default class QuestionsView extends Component {
	render() {
		return (
				<QuestionsList uri={Constants.FULL_QUESTION_API_URI}/>
		);
	}
}