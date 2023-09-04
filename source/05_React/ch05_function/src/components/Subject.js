import './Subject.css';

let Subject = props => {

  return (
    <header className='subject'>
      <h1 onClick={() => {
        props.onChangePage();
      }}>{props.title}</h1>
    </header>
  );
};

export default Subject;