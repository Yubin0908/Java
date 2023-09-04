let UpdateContent = (props) => {
  const onUpdate = (e) => {
    e.preventDefault();
    props.onUpdate(Number(props._id.value), props._title.value, props._desc.value);
  };

  return (
    <article>
      <h2>UPDATE</h2>
      <form onSubmit={onUpdate}>
        <p><input type="hidden" name="id" defaultValue={props.data.id} /></p>
        <p><input type="text" name="title" defaultValue={props.data.title} /></p>
        <p><textarea name="desc" defaultValue={props.data.desc} /></p>
        <p><input type="submit" value="수정" /></p>
      </form>
    </article>
  );
};

export default UpdateContent;
