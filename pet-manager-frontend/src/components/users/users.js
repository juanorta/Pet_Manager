import React, { Component } from 'react';
import { DataGrid } from '@material-ui/data-grid';

class Users extends Component {
	state = {
		isLoading: true,
		users: [],
	};

	componentDidMount() {
		fetch('/api/users', {
			headers: {
				'Content-Type': 'application/json',
				Accept: 'application/json',
			},
		})
			.then((res) => res.json())
			.then((users) =>
				this.setState({ users, isLoading: false }, () =>
					console.log('users fetched...', users)
				)
			);
	}

	render() {
		const { users, isLoading } = this.state;

		const columns = [
			{ field: 'id', headerName: 'ID', width: 70 },
			{ field: 'first_name', headerName: 'First name', width: 130 },
			{ field: 'last_name', headerName: 'Last name', width: 130 },
			{ field: 'email', headerName: 'Email', width: 200 },
			{ field: 'social_type', headerName: 'Social Type', width: 130 },
		];

		const rows = [];
		for (let i = 0; i < users.length; i++) {
			rows[i] = users[i];
		}
		return (
			<div>
				<div style={{ height: 450, width: '100%' }}>
					<DataGrid rows={rows} columns={columns} pageSize={10} />
				</div>
			</div>
		);
	}
}

export default Users;
