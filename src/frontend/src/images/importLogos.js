// Function used to import all logos from the logos folder

function importAll(r) {
    let images = {};
    r.keys().forEach((item, index) => {
        const key = item.replace('./', '').replace(/\.png$/, '');
        images[key] = r(item);
    });
    return images;
}

const logos = importAll(require.context('./logos', false, /\.png$/));

export default logos;