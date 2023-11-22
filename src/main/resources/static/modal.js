async function openAndFillInTheModal(form, modal, id) {
    modal.show();
    let user = await getOneUser(id);
    form.id.value = user.id;
    form.username.value = user.username;
    form.email.value = user.email;
    form.roles.value = user.roles.join(',');
}