/**
 * FullCalendar用JS
 */

document.addEventListener('DOMContentLoaded', function() {
	var calendarEl = document.getElementById('calendar');
	var calendar = new FullCalendar.Calendar(calendarEl, {
		headerToolbar: {
			left: 'prev,next today',
			center: 'title',
			right: 'dayGridMonth,timeGridWeek,timeGridDay,listMonth'
		},
		locale: 'ja', // 日本語
		navLinks: true, // 日付クリック
		businessHours: {
			endTime: '18:00'
		}, // 業務時間 9:00～18:00
		editable: true, // ドラッグ編集可
		selectable: true, // 選択で強調表示
		nowIndicator: true, // 現在時刻に赤線
		dayMaxEvents: true, // セルの高さ以上のイベントは+moreで表示
		events: [{
			title: 'Business Lunch',
			start: '2025-01-03T13:00:00',
			constraint: 'businessHours'
		}, {
			title: 'Meeting',
			start: '2025-01-13T11:00:00',
			constraint: 'availableForMeeting', // defined below
			color: '#257e4a'
		}, {
			title: 'Conference',
			start: '2025-01-18',
			end: '2025-01-20'
		}, {
			title: 'Party',
			start: '2025-01-29T20:00:00'
		},

		// areas where "Meeting" must be dropped
		{
			groupId: 'availableForMeeting',
			start: '2025-01-11T10:00:00',
			end: '2025-01-11T16:00:00',
			display: 'background'
		}, {
			groupId: 'availableForMeeting',
			start: '2025-01-13T10:00:00',
			end: '2025-01-13T16:00:00',
			display: 'background'
		},

		// red areas where no events can be dropped
		{
			start: '2025-01-24',
			end: '2025-01-28',
			overlap: false,
			display: 'background',
			color: '#ff9f89'
		}, {
			start: '2025-01-06',
			end: '2025-01-08',
			overlap: false,
			display: 'background',
			color: '#ff9f89'
		}]
	});
	calendar.render();
});