
let CreateContent = props => {
  return (
    <article>
      <h2>CREATE</h2>
      <form onSubmit={e =>{
        e.preventDefault();
        props.onCreate(e.target.title.value, e.target.desc.value);
      }}>
        <p><input type='text' name='title' placeholder="title" /></p>
        <p><textarea name='desc' placeholder="desc" /></p>
        <p><input type='submit' value='추가' /></p>
      </form>
    </article>
  )
};

export default CreateContent;