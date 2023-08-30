import React, { Component } from 'react';
import './App.css';

class App extends Component {
  render() {
    return (
      <div className="App">
        Hello, React!
        <Subject></Subject>
        </div>
    );
  }
};
class Subject extends Component {
  render() {
    return (
      <header>
        <h1>WEB</h1>
        World Wide Web!
      </header>
    );
    }
};

export default App; // 외부에서 import 할 수 있도록 해주는 역할
