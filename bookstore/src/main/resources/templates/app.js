// Define the function to fetch and display posts
function fetchAndDisplayPosts() {
    // Show loading indicator
    document.getElementById('loadingIndicator').style.display = 'block';

    axios.get('http://localhost:8080/Bookstore/getall')
        .then(res => {
            console.log('Response data:', res.data); // Logs the data part of the response
            
            // Display posts on the new page
            displayPosts(res.data);
        })
        .catch(error => {
            console.error('Error fetching data:', error); // Logs any errors
            
            // Provide user feedback
            document.getElementById('dataContainer').innerHTML = `<p>Error fetching data. Please try again later.</p>`;
        })
        .finally(() => {
            // Hide loading indicator
            document.getElementById('loadingIndicator').style.display = 'none';
        });
}

function displayPosts(posts) {
    // Assuming posts is an array of objects
    const container = document.getElementById('dataContainer');
    container.innerHTML = ''; // Clear existing content

    if (posts.length === 0) {
        container.innerHTML = '<p>No posts available.</p>';
        return;
    }

    // Generate HTML for each post
    posts.forEach(post => {
        const postElement = document.createElement('div');
        postElement.classList.add('post');
        postElement.innerHTML = `
            <h2>${post.title}</h2>
            <p>QUANTITY:${post.quantity}</p>
            <p>${post.id}</p>
            <p>${post.author}</p>


        `;
        container.appendChild(postElement);
    });
}

function handleLogin() {
    // Perform login actions if needed, then redirect to the data page
    window.location.href = 'dataPage.html';
}
function displayPosts(posts) {
    const container = document.getElementById('dataContainer');
    container.innerHTML = ''; // Clear existing content

    if (posts.length === 0) {
        container.innerHTML = '<p>No posts available.</p>';
        return;
    }

    // Generate HTML for each post
    posts.forEach(post => {
        const postElement = document.createElement('div');
        postElement.classList.add('post');
        postElement.innerHTML = `
            <h2>${post.title}</h2>
            
            <p>QUANTITY: ${post.quantity}</p>
            <p>${post.id}</p>
            <p>${post.author}</p>
            <button onclick="deletePost(${post.id})">Delete</button>
        `;
        container.appendChild(postElement);
    });
}

function deletePost(postId) {
    axios.delete(`http://localhost:8080/Bookstore/delete/${postId}`)
        .then(response => {
            fetchAndDisplayPosts(); // Refresh the list of posts
        })
        .catch(error => {
            console.error('Error deleting post:', error);
        });
}

