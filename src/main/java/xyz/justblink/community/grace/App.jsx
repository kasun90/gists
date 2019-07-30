import React, { Component }from 'react';
import './App.css';
import Grace from 'react-grace';

class App extends Component {

	constructor(props) {
		super(props);
		this.state = {
			data: undefined
		}
	}

	componentDidMount() {
		fetch('http://localhost:8000')
			.then(response => response.json())
			.then(_data =>  {
				this.setState({
					data: _data
				});
				console.log(_data);
			});
	}

	render() {
		return (
			<div className="App">
				<Grace document={this.state.data}/>
			</div>
		  );
	}
}

export default App;